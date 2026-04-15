package generated

final case class Data1477(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1477 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1477 = copy(value = value * k)
  def addTag(t: String): Data1477 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1477 = copy(meta = meta.updated(k, v))
  def merge(other: Data1477): Data1477 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1477 {
  given Ordering[Data1477] = Ordering.by(_.id)
  def empty: Data1477 = Data1477(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1477 =
    Data1477(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1477] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
