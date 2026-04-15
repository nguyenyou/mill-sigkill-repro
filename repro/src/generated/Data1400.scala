package generated

final case class Data1400(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1400 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1400 = copy(value = value * k)
  def addTag(t: String): Data1400 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1400 = copy(meta = meta.updated(k, v))
  def merge(other: Data1400): Data1400 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1400 {
  given Ordering[Data1400] = Ordering.by(_.id)
  def empty: Data1400 = Data1400(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1400 =
    Data1400(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1400] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
