package generated

final case class Data203(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data203 = copy(name = name.toUpperCase)
  def scale(k: Double): Data203 = copy(value = value * k)
  def addTag(t: String): Data203 = copy(tags = t :: tags)
  def put(k: String, v: String): Data203 = copy(meta = meta.updated(k, v))
  def merge(other: Data203): Data203 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data203 {
  given Ordering[Data203] = Ordering.by(_.id)
  def empty: Data203 = Data203(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data203 =
    Data203(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data203] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
