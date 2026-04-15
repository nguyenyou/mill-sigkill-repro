package generated

final case class Data375(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data375 = copy(name = name.toUpperCase)
  def scale(k: Double): Data375 = copy(value = value * k)
  def addTag(t: String): Data375 = copy(tags = t :: tags)
  def put(k: String, v: String): Data375 = copy(meta = meta.updated(k, v))
  def merge(other: Data375): Data375 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data375 {
  given Ordering[Data375] = Ordering.by(_.id)
  def empty: Data375 = Data375(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data375 =
    Data375(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data375] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
