package generated

final case class Data1240(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1240 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1240 = copy(value = value * k)
  def addTag(t: String): Data1240 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1240 = copy(meta = meta.updated(k, v))
  def merge(other: Data1240): Data1240 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1240 {
  given Ordering[Data1240] = Ordering.by(_.id)
  def empty: Data1240 = Data1240(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1240 =
    Data1240(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1240] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
