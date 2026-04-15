package generated

final case class Data506(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data506 = copy(name = name.toUpperCase)
  def scale(k: Double): Data506 = copy(value = value * k)
  def addTag(t: String): Data506 = copy(tags = t :: tags)
  def put(k: String, v: String): Data506 = copy(meta = meta.updated(k, v))
  def merge(other: Data506): Data506 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data506 {
  given Ordering[Data506] = Ordering.by(_.id)
  def empty: Data506 = Data506(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data506 =
    Data506(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data506] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
