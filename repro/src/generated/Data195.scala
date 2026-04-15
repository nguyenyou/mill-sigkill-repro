package generated

final case class Data195(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data195 = copy(name = name.toUpperCase)
  def scale(k: Double): Data195 = copy(value = value * k)
  def addTag(t: String): Data195 = copy(tags = t :: tags)
  def put(k: String, v: String): Data195 = copy(meta = meta.updated(k, v))
  def merge(other: Data195): Data195 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data195 {
  given Ordering[Data195] = Ordering.by(_.id)
  def empty: Data195 = Data195(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data195 =
    Data195(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data195] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
