package generated

final case class Data698(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data698 = copy(name = name.toUpperCase)
  def scale(k: Double): Data698 = copy(value = value * k)
  def addTag(t: String): Data698 = copy(tags = t :: tags)
  def put(k: String, v: String): Data698 = copy(meta = meta.updated(k, v))
  def merge(other: Data698): Data698 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data698 {
  given Ordering[Data698] = Ordering.by(_.id)
  def empty: Data698 = Data698(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data698 =
    Data698(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data698] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
