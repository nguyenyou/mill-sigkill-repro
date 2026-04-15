package generated

final case class Data1319(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1319 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1319 = copy(value = value * k)
  def addTag(t: String): Data1319 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1319 = copy(meta = meta.updated(k, v))
  def merge(other: Data1319): Data1319 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1319 {
  given Ordering[Data1319] = Ordering.by(_.id)
  def empty: Data1319 = Data1319(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1319 =
    Data1319(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1319] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
