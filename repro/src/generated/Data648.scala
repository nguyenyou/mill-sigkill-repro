package generated

final case class Data648(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data648 = copy(name = name.toUpperCase)
  def scale(k: Double): Data648 = copy(value = value * k)
  def addTag(t: String): Data648 = copy(tags = t :: tags)
  def put(k: String, v: String): Data648 = copy(meta = meta.updated(k, v))
  def merge(other: Data648): Data648 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data648 {
  given Ordering[Data648] = Ordering.by(_.id)
  def empty: Data648 = Data648(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data648 =
    Data648(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data648] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
