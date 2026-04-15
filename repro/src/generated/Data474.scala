package generated

final case class Data474(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data474 = copy(name = name.toUpperCase)
  def scale(k: Double): Data474 = copy(value = value * k)
  def addTag(t: String): Data474 = copy(tags = t :: tags)
  def put(k: String, v: String): Data474 = copy(meta = meta.updated(k, v))
  def merge(other: Data474): Data474 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data474 {
  given Ordering[Data474] = Ordering.by(_.id)
  def empty: Data474 = Data474(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data474 =
    Data474(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data474] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
