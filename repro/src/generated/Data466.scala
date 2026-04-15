package generated

final case class Data466(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data466 = copy(name = name.toUpperCase)
  def scale(k: Double): Data466 = copy(value = value * k)
  def addTag(t: String): Data466 = copy(tags = t :: tags)
  def put(k: String, v: String): Data466 = copy(meta = meta.updated(k, v))
  def merge(other: Data466): Data466 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data466 {
  given Ordering[Data466] = Ordering.by(_.id)
  def empty: Data466 = Data466(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data466 =
    Data466(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data466] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
