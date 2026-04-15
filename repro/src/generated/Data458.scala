package generated

final case class Data458(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data458 = copy(name = name.toUpperCase)
  def scale(k: Double): Data458 = copy(value = value * k)
  def addTag(t: String): Data458 = copy(tags = t :: tags)
  def put(k: String, v: String): Data458 = copy(meta = meta.updated(k, v))
  def merge(other: Data458): Data458 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data458 {
  given Ordering[Data458] = Ordering.by(_.id)
  def empty: Data458 = Data458(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data458 =
    Data458(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data458] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
