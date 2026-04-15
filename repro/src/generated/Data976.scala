package generated

final case class Data976(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data976 = copy(name = name.toUpperCase)
  def scale(k: Double): Data976 = copy(value = value * k)
  def addTag(t: String): Data976 = copy(tags = t :: tags)
  def put(k: String, v: String): Data976 = copy(meta = meta.updated(k, v))
  def merge(other: Data976): Data976 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data976 {
  given Ordering[Data976] = Ordering.by(_.id)
  def empty: Data976 = Data976(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data976 =
    Data976(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data976] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
