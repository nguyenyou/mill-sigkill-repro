package generated

final case class Data1452(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1452 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1452 = copy(value = value * k)
  def addTag(t: String): Data1452 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1452 = copy(meta = meta.updated(k, v))
  def merge(other: Data1452): Data1452 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1452 {
  given Ordering[Data1452] = Ordering.by(_.id)
  def empty: Data1452 = Data1452(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1452 =
    Data1452(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1452] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
