package generated

final case class Data213(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data213 = copy(name = name.toUpperCase)
  def scale(k: Double): Data213 = copy(value = value * k)
  def addTag(t: String): Data213 = copy(tags = t :: tags)
  def put(k: String, v: String): Data213 = copy(meta = meta.updated(k, v))
  def merge(other: Data213): Data213 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data213 {
  given Ordering[Data213] = Ordering.by(_.id)
  def empty: Data213 = Data213(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data213 =
    Data213(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data213] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
