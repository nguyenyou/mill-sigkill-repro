package generated

final case class Data1058(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1058 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1058 = copy(value = value * k)
  def addTag(t: String): Data1058 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1058 = copy(meta = meta.updated(k, v))
  def merge(other: Data1058): Data1058 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1058 {
  given Ordering[Data1058] = Ordering.by(_.id)
  def empty: Data1058 = Data1058(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1058 =
    Data1058(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1058] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
