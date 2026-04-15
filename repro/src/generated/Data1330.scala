package generated

final case class Data1330(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1330 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1330 = copy(value = value * k)
  def addTag(t: String): Data1330 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1330 = copy(meta = meta.updated(k, v))
  def merge(other: Data1330): Data1330 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1330 {
  given Ordering[Data1330] = Ordering.by(_.id)
  def empty: Data1330 = Data1330(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1330 =
    Data1330(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1330] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
