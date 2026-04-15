package generated

final case class Data1350(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1350 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1350 = copy(value = value * k)
  def addTag(t: String): Data1350 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1350 = copy(meta = meta.updated(k, v))
  def merge(other: Data1350): Data1350 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1350 {
  given Ordering[Data1350] = Ordering.by(_.id)
  def empty: Data1350 = Data1350(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1350 =
    Data1350(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1350] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
