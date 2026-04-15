package generated

final case class Data18(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data18 = copy(name = name.toUpperCase)
  def scale(k: Double): Data18 = copy(value = value * k)
  def addTag(t: String): Data18 = copy(tags = t :: tags)
  def put(k: String, v: String): Data18 = copy(meta = meta.updated(k, v))
  def merge(other: Data18): Data18 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data18 {
  given Ordering[Data18] = Ordering.by(_.id)
  def empty: Data18 = Data18(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data18 =
    Data18(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data18] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
