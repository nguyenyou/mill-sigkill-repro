package generated

final case class Data1278(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1278 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1278 = copy(value = value * k)
  def addTag(t: String): Data1278 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1278 = copy(meta = meta.updated(k, v))
  def merge(other: Data1278): Data1278 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1278 {
  given Ordering[Data1278] = Ordering.by(_.id)
  def empty: Data1278 = Data1278(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1278 =
    Data1278(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1278] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
