package generated

final case class Data1020(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1020 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1020 = copy(value = value * k)
  def addTag(t: String): Data1020 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1020 = copy(meta = meta.updated(k, v))
  def merge(other: Data1020): Data1020 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1020 {
  given Ordering[Data1020] = Ordering.by(_.id)
  def empty: Data1020 = Data1020(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1020 =
    Data1020(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1020] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
